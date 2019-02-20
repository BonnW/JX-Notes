package com.burahan.h2cruddy.repository;

import com.burahan.h2cruddy.models.Snack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepository extends JpaRepository<Snack, Long>
{
}
