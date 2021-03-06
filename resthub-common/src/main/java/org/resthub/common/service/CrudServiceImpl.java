package org.resthub.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.util.Assert;

/**
 * Crud service that uses a repository implementation
 * You should extend it and inject your Repository bean by overriding setRepository
 *
 * @param <T> Your resource class to manage, maybe an entity or DTO class
 * @param <ID> Resource id type, usually Long or String
 * @param <R> The repository class
 */
public class CrudServiceImpl<T, ID extends Serializable, R extends PagingAndSortingRepository<T, ID>> implements
        CrudService<T, ID> {

    protected R repository;

    /**
     * @param repository
     *            the repository to set
     */
    public void setRepository(R repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T create(T resource) {
        Assert.notNull(resource, "Resource can't be null");
        return repository.save(resource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T update(T resource) {
        Assert.notNull(resource, "Resource can't be null");
        return repository.save(resource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T resource) {
        Assert.notNull(resource, "Resource can't be null");
        repository.delete(resource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(ID id) {
        Assert.notNull(id, "Resource ID can't be null");
        repository.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllWithCascade() {
        Iterable<T> list = repository.findAll();
        for (T entity : list) {
            repository.delete(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(ID id) {
        Assert.notNull(id, "Resource ID can't be null");
        return repository.findOne(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<T> findAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return repository.count();
    }
}
