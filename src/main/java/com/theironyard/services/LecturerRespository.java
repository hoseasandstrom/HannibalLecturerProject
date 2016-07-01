package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hoseasandstrom on 7/1/16.
 */
public interface LecturerRespository extends CrudRepository<Lecturer, Integer> {
}
