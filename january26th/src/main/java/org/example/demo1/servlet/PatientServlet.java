package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.dao.PatientDAOImpl;
import org.example.demo1.models.Patient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "patient", value ="/patient")
public class PatientServlet extends HttpServlet {

    private PatientDAOImpl bloup;

    private List<Patient> demission = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        bloup = new PatientDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        demission = bloup.ReadAll();
        System.out.println(demission);
        req.setAttribute("patients", demission);
        req.getRequestDispatcher("patient.jsp").forward(req,resp);
    }

}
