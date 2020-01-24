package com.github.danimaniarqsoft.web.rest;

import com.github.danimaniarqsoft.service.LinkService;
import com.github.danimaniarqsoft.web.rest.errors.BadRequestAlertException;
import com.github.danimaniarqsoft.service.dto.LinkDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.github.danimaniarqsoft.domain.Link}.
 */
@RestController
@RequestMapping("/api")
public class LinkResource {

    private final Logger log = LoggerFactory.getLogger(LinkResource.class);

    private static final String ENTITY_NAME = "link";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LinkService linkService;

    public LinkResource(LinkService linkService) {
        this.linkService = linkService;
    }

    /**
     * {@code POST  /links} : Create a new link.
     *
     * @param linkDTO the linkDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new linkDTO, or with status {@code 400 (Bad Request)} if the link has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/links")
    public ResponseEntity<LinkDTO> createLink(@Valid @RequestBody LinkDTO linkDTO) throws URISyntaxException {
        log.debug("REST request to save Link : {}", linkDTO);
        if (linkDTO.getId() != null) {
            throw new BadRequestAlertException("A new link cannot already have an ID", ENTITY_NAME, "idexists");
        }
        LinkDTO result = linkService.save(linkDTO);
        return ResponseEntity.created(new URI("/api/links/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /links} : Updates an existing link.
     *
     * @param linkDTO the linkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated linkDTO,
     * or with status {@code 400 (Bad Request)} if the linkDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the linkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/links")
    public ResponseEntity<LinkDTO> updateLink(@Valid @RequestBody LinkDTO linkDTO) throws URISyntaxException {
        log.debug("REST request to update Link : {}", linkDTO);
        if (linkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        LinkDTO result = linkService.save(linkDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, linkDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /links} : get all the links.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of links in body.
     */
    @GetMapping("/links")
    public ResponseEntity<List<LinkDTO>> getAllLinks(Pageable pageable) {
        log.debug("REST request to get a page of Links");
        Page<LinkDTO> page = linkService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /links/:id} : get the "id" link.
     *
     * @param id the id of the linkDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the linkDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/links/{id}")
    public ResponseEntity<LinkDTO> getLink(@PathVariable String id) {
        log.debug("REST request to get Link : {}", id);
        Optional<LinkDTO> linkDTO = linkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(linkDTO);
    }

    /**
     * {@code DELETE  /links/:id} : delete the "id" link.
     *
     * @param id the id of the linkDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/links/{id}")
    public ResponseEntity<Void> deleteLink(@PathVariable String id) {
        log.debug("REST request to delete Link : {}", id);
        linkService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
