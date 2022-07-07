package helper;

import helper.Messages.AppMessage;
import model.BookDto;
import model.ValidDto;
import repository.AuthorRepository;

import static helper.IntegerHelper.*;
import static helper.Messages.AppMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private AuthorRepository authorRepository = new AuthorRepository();
    public static List<ValidDto> checkAllIntegers(BookDto bookDto)
    {
        List<ValidDto> errors = new ArrayList<>();

        if(!isDigit(String.valueOf(bookDto.getAuthorId())))
            errors.add(new ValidDto("authorId", IS_NOT_DIGIT));

        if(!isDigit(String.valueOf(bookDto.getLeftNumberOfBooks())))
            errors.add(new ValidDto("leftNumberOfBooks",IS_NOT_DIGIT));

        if(!isDigit(String.valueOf(bookDto.getTotalNumberOfBooks())))
            errors.add(new ValidDto("totalNumberOfBooks",IS_NOT_DIGIT));

        if(!isDigit(String.valueOf(bookDto.getPageCount())))
            errors.add(new ValidDto("pageCount",IS_NOT_DIGIT));
        return errors;
    }
    public static List<ValidDto> checkIsNegative(BookDto bookDto)
    {
        List<ValidDto> errors = new ArrayList<>();

        if(bookDto.getAuthorId()<1)
            errors.add(new ValidDto("AuthorId",NEGATIVE_ERROR));

        if(bookDto.getCost()<1)
            errors.add(new ValidDto("Cost",NEGATIVE_ERROR));

        if(bookDto.getLeftNumberOfBooks()<1)
            errors.add(new ValidDto("leftNUmberOfBooks",NEGATIVE_ERROR));

        if(bookDto.getTotalNumberOfBooks()<1)
            errors.add(new ValidDto("totalNumberOfBooks",NEGATIVE_ERROR));

        if(bookDto.getPageCount()<1)
            errors.add(new ValidDto("pageCount",NEGATIVE_ERROR));
        return errors;
    }

}
