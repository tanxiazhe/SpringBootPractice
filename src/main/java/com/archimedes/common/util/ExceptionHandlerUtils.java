package com.archimedes.common.util;

import org.springframework.data.repository.CrudRepository;

import com.archimedes.common.exception.BadRequestException;
import com.archimedes.common.exception.NotFoundException;

public class ExceptionHandlerUtils {

	public static void throwIfIdNotNull(final Long id) {
		if (id != null && id.intValue() != 0) {
			String message = String
					.format("Remove 'id' property from request or use PATCH method to update resource with id = %d", id);
			throw new BadRequestException(message);
		}
	}

	public static void throwIfNonexisting(CrudRepository<?, Long> repository, long id) {
		if (!repository.existsById(id)) {
			NotFoundException notFoundException = new NotFoundException("request failed, "+id + " not found");
			throw notFoundException;
		}
	}

	public static void throwIfInconsistent(Long expected, Long actual) {
		if (!expected.equals(actual)) {
			String message = String.format(
					"bad request, inconsistent IDs between request and object: request id = %d, object id = %d",
					expected, actual);
			throw new BadRequestException(message);
		}
	}
}
