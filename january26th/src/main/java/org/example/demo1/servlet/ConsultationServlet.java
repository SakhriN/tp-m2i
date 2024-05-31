package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.dao.ConsultationDAOImpl;
import org.example.demo1.dao.PatientDAOImpl;
import org.example.demo1.models.Consultation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "consultation", value = "/consultation")
public class ConsultationServlet extends HttpServlet {

    private ConsultationDAOImpl bloup;

    private List<Consultation> demission = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        bloup = new ConsultationDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ids = req.getParameter("id");
        int id = 0;

        System.out.println(demission);

        if (ids != null) {
            id = Integer.parseInt(ids);

            demission = bloup.ReadById(id);
            req.setAttribute("patId", id);
            req.setAttribute("consultations", demission);
            req.getRequestDispatcher("consultation.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("patient.jsp").forward(req, resp);
        }
    }

}
