/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

/**
 * @author Gustavo Rubin
 *
 */
public class PageableResourceService implements PageableResourceCrudUseCase {

    private final PageableResourceRepositoryPort pageableResourceRepositoryPort;

    /**
     * @param pageableResourceRepositoryPort
     */
    public PageableResourceService(PageableResourceRepositoryPort pageableResourceRepositoryPort) {
	this.pageableResourceRepositoryPort = pageableResourceRepositoryPort;
    }

    @Override
    public PageableResource create(PageableResource newPageableResource) {
	Assert.hasLength(newPageableResource.getText(), "text cannot be null");

	return this.pageableResourceRepositoryPort.save(newPageableResource);
    }

    @Override
    public Page<PageableResource> findAll(Pageable pageable) {
	return this.pageableResourceRepositoryPort.findAll(pageable);
    }

    @Override
    public PageableResource findById(Long id) {
	PageableResource registeredPageableResource = this.pageableResourceRepositoryPort.findById(id);
	Assert.notNull(registeredPageableResource, "pageableResource not registered");

	return registeredPageableResource;
    }

    @Override
    public PageableResource findByText(String text) {
	return this.pageableResourceRepositoryPort.findByText(text);
    }

    @Override
    public PageableResource update(Long id, PageableResource newPageableResource) {
	Assert.hasLength(newPageableResource.getText(), "text cannot be null");
	PageableResource registeredPageableResource = this.pageableResourceRepositoryPort.findById(id);
	Assert.notNull(registeredPageableResource, "pageableResource not registered");

	newPageableResource.setId(id);

	return this.pageableResourceRepositoryPort.save(newPageableResource);
    }

    @Override
    public void delete(Long id) {
	PageableResource registeredPageableResource = this.pageableResourceRepositoryPort.findById(id);
	Assert.notNull(registeredPageableResource, "pageableResource not registered");

	this.pageableResourceRepositoryPort.delete(id);
    }

}
