package com.aniket.Library.Management.App.repository;

import com.aniket.Library.Management.App.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
