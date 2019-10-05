package com.dc.locationweb.dao.repository;

import com.dc.locationweb.dao.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
