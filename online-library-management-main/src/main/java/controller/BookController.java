package controller;

import jdk.jshell.Snippet;
import model.BookDto;
import model.ResponseDto;
import service.BookService;
import static helper.IntegerHelper.*;
import static helper.DoubleHelper.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("AddBook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String bookName = req.getParameter("NameBook");
            String cost = req.getParameter("Cost");
            String genre = req.getParameter("genre");
            String pageCount = req.getParameter("PageCount");
            String totalNumberOfBooks = req.getParameter("TotalCount");
            String leftNumberOfBooks = req.getParameter("LeftNumber");
            String authorId = req.getParameter("AuthorId");

            boolean costBol = checkDouble(cost);
            boolean total = isDigit(cost);
            boolean left = isDigit(cost);
            boolean pageCountBol = isDigit(cost);
            boolean authorIdBol = isDigit(cost);
            if( !total || !left || !pageCountBol || !authorIdBol) {
                resp.getWriter().write("Please enter right number ");
                resp.setStatus(400);
            }
            else if(!costBol) {
                resp.getWriter().write("Please enter right cost");
                resp.setStatus(400,"BAD REQUEST");
            }



            BookDto bookDto = BookDto.builder()
                    .name(bookName)
                    .cost(Double.parseDouble(cost))
                    .genre(genre)
                    .pageCount(Integer.parseInt(pageCount))
                    .totalNumberOfBooks(Integer.parseInt(totalNumberOfBooks))
                    .leftNumberOfBooks(Integer.parseInt(leftNumberOfBooks))
                    .authorId(Integer.parseInt(authorId))
                    .build();
           ResponseDto<BookDto> responseDto =  bookService.addBook(bookDto);
           resp.getWriter().write(responseDto.getMessage());
        }catch (Exception e)
        {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }

    }
}
