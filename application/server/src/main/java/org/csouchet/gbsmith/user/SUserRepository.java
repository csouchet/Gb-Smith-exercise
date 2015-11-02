/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.user;

import org.csouchet.gbsmith.persitence.SUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Souchet Celine
 */
public interface SUserRepository extends PagingAndSortingRepository<SUser, Long> {

}
