/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.adapters;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.gusrubin.lab.springgenerallab.domain.pagination.PageableResource;
import com.gusrubin.lab.springgenerallab.domain.pagination.PageableResourceRepositoryPort;
import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.PageableResourceEntity;
import com.gusrubin.lab.springgenerallab.infrastructure.database.repositories.PageableResourceRepository;

/**
 * @author Gustavo Rubin
 *
 */
@Component
public class PageableResourceRepositoryPortAdapter implements PageableResourceRepositoryPort {

    private final PageableResourceRepository pageableResourceRepository;
    private final ModelMapper modelMapper;

    /**
     * @param pageableResourceRepository
     * @param modelMapper
     */
    public PageableResourceRepositoryPortAdapter(PageableResourceRepository pageableResourceRepository,
	    ModelMapper modelMapper) {
	this.pageableResourceRepository = pageableResourceRepository;
	this.modelMapper = modelMapper;
    }

    @Override
    public PageableResource save(PageableResource newPageableResource) {
	return toDomain(this.pageableResourceRepository.save(toEntity(newPageableResource)));
    }

    @Override
    public Page<PageableResource> findAll(Pageable pageable) {
	return this.pageableResourceRepository.findAll(pageable).map(this::toDomain);
    }

    @Override
    public PageableResource findById(Long id) {
	PageableResourceEntity entity = this.pageableResourceRepository.findById(id).orElse(null);
	return entity != null ? toDomain(entity) : null;
    }

    @Override
    public PageableResource findByText(String text) {
	return this.pageableResourceRepository.findByText(text).map(this::toDomain).orElse(null);
    }

    @Override
    public void delete(Long id) {
	this.pageableResourceRepository.deleteById(id);
    }

    private PageableResource toDomain(PageableResourceEntity entity) {
	return this.modelMapper.map(entity, PageableResource.class);
    }

    private PageableResourceEntity toEntity(PageableResource domain) {
	return this.modelMapper.map(domain, PageableResourceEntity.class);
    }

}
