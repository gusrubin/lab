/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.servicebeans;

import org.springframework.stereotype.Service;

import com.gusrubin.lab.springgenerallab.domain.pagination.PageableResourceRepositoryPort;
import com.gusrubin.lab.springgenerallab.domain.pagination.PageableResourceService;

/**
 * @author Gustavo Rubin
 *
 */
@Service
public class PageableResourceServiceBean extends PageableResourceService {

    /**
     * @param pageableResourceRepositoryPort
     */
    public PageableResourceServiceBean(PageableResourceRepositoryPort pageableResourceRepositoryPort) {
	super(pageableResourceRepositoryPort);
    }

}
