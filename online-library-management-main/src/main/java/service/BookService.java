package service;
import entity.Book;
import model.BookDto;
import model.ResponseDto;
import model.ValidDto;
import repository.AuthorRepository;
import repository.BookRepository;

import java.util.List;

import static helper.Validation.*;

public class BookService {
    private BookRepository bookRepository = new BookRepository();
    private AuthorRepository authorRepository = new AuthorRepository();


    public ResponseDto<BookDto> addBook(BookDto bookDto)
    {
        List<ValidDto> errors = checkIsNegative(bookDto);
        if(errors.size()>0)
            return new ResponseDto<>(false, "Valid Error" ,null,errors);
        if(authorRepository.getAuthorById(bookDto.getAuthorId())==null)
            return new ResponseDto<>(false,"Author Id is not found",null);
            try {
           bookDto = bookRepository.addBook(bookDto);

           return new ResponseDto<>(true,"Ok",bookDto);
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseDto<>(false,"Save Error" );
        }
    }
}
