package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.dao.ConsultationDAOImpl;
import org.example.demo1.dao.FicheSoinDAOImpl;
import org.example.demo1.dao.PrescriptionDAOImpl;
import org.example.demo1.models.Consultation;
import org.example.demo1.models.FicheSoin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "fichesoin", value ="/fichesoin")
public class FicheSoinServlet extends HttpServlet {

    private FicheSoinDAOImpl bloup;

    private List<FicheSoin> demission = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        bloup = new FicheSoinDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ids = req.getParameter("conId");
        int id = 0;

        System.out.println(demission);
        System.out.println(ids);

        if (ids != null) {
            int patId = Integer.parseInt(req.getParameter("patId"));
            id = Integer.parseInt(ids);
            demission = bloup.ReadById(id);
            req.setAttribute("conId", id);
            req.setAttribute("patId", patId);
            req.setAttribute("fichessoin", demission);
            req.getRequestDispatcher("fichesoin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("patient.jsp").forward(req, resp);
        }
    }
}

