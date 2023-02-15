package by.it_academy.jd2.Mk_JD2_95_22.vote_server.controllers.servlet;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultArtistDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultGenreDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IResultVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.ResultVoteServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    ResultGenreDto resultGenre;
    ResultVoteDto resultVoteDto;
    private final IResultVoteService service;

    public ResultServlet() {
        this.service = ResultVoteServiceSingleton.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        resultVoteDto = service.getResult();
        List<ResultArtistDto> resultArtist = resultVoteDto.getResultArtist();
        List<ResultGenreDto> resultGenre = resultVoteDto.getResultGenre();

        resultArtist.forEach((k) -> writer.write("<p>" + k.getNumberArtist() + " - " + k.getCount()));
//        resultGenre.forEach(k -> writer.write(k.getNumberGenre() + " - " + k.getCount()));

    }
}
