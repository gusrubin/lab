/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Gustavo Rubin
 *
 */
public interface PageableResourceRepositoryPort {

    PageableResource save(PageableResource newPageableResource);

    Page<PageableResource> findAll(Pageable pageable);

    PageableResource findById(Long id);

    PageableResource findByText(String text);

    void delete(Long id);

}
