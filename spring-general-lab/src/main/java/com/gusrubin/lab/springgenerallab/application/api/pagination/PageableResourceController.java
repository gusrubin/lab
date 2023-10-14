/**
 * 
 */
package com.gusrubin.lab.springgenerallab.application.api.pagination;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import com.gusrubin.lab.springgenerallab.domain.pagination.PageableResource;
import com.gusrubin.lab.springgenerallab.domain.pagination.PageableResourceCrudUseCase;
import lombok.RequiredArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@RestController
@RequestMapping("api/pageables")
@RequiredArgsConstructor
public class PageableResourceController {

    private final PageableResourceCrudUseCase pageableResourceCrudUseCase;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PageableResource postPageableResource(@RequestBody NewPageableResourceDto requestBody) {
        return this.pageableResourceCrudUseCase.create(this.modelMapper.map(requestBody, PageableResource.class));
    }

    @GetMapping
    public Page<PageableResource> getAllPageableResources(@ParameterObject Pageable pageable,
            @RequestParam(value = "text", required = false) String text) {
        Page<PageableResource> pageableResourceList = null;

        if (text != null) {
            PageableResource pageableResource = this.pageableResourceCrudUseCase.findByText(text);

            pageableResourceList = new PageImpl<>(List.of(pageableResource));

        } else {
            pageableResourceList = this.pageableResourceCrudUseCase.findAll(pageable);
        }

        return pageableResourceList;
    }

    @GetMapping("/{id}")
    public PageableResource getPageableResourceById(@PathVariable("id") Long id) {
        return this.pageableResourceCrudUseCase.findById(id);
    }

    @PutMapping("/{id}")
    public PageableResource putPageableResourceById(@PathVariable("id") Long id,
            @RequestBody NewPageableResourceDto requestBody) {
        return this.pageableResourceCrudUseCase.update(id, this.modelMapper.map(requestBody, PageableResource.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePageableResourceById(@PathVariable("id") Long id) {
        pageableResourceCrudUseCase.delete(id);
    }

}
