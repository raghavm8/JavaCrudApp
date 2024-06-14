package org.raghav.mycrudapp.Repository;

import org.raghav.mycrudapp.Models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

}
