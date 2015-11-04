/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spot_fitness.servlet;

import com.mycompany.sport_fitness.doa.CadastroProdutoDAO;
import com.mycompany.sport_fitness.doa.LoginDAO;
import com.mycompany.spot_fitness.entidade.CadastroProdutoBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipe
 */
public class cadProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cadProdutoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cadProdutoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * *
     *
     * private int codigo; private String nome; private String categoria;
     * private String descricao; private String fabricante; private String
     * fornecedor; private float altura; private float largura; private float
     * profundidade; private float valorCompra; private float valorVenda;
     * private float lucro;
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CadastroProdutoBean cadastro = new CadastroProdutoBean();
        cadastro.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        cadastro.setNome(request.getParameter("nome"));
        cadastro.setCategoria(request.getParameter("categoria"));
        cadastro.setDescricao(request.getParameter("descricao"));
        cadastro.setFabricante(request.getParameter("fabricante"));
        cadastro.setFornecedor(request.getParameter("fornecedor"));
        cadastro.setAltura(Float.parseFloat(request.getParameter("altura")));
        cadastro.setLargura(Float.parseFloat(request.getParameter("largura")));
        cadastro.setProfundidade(Float.parseFloat(request.getParameter("profundidade")));
        cadastro.setValorCompra(Float.parseFloat(request.getParameter("valorCompra")));
        cadastro.setValorVenda(Float.parseFloat(request.getParameter("valorVenda")));
        cadastro.setLucro(Float.parseFloat(request.getParameter("lucro")));
        

        CadastroProdutoDAO cad = new CadastroProdutoDAO();
        boolean verd = cad.cadastro(cadastro);
        if (verd) {
            response.sendRedirect("html/Home.html");
        } else {
            //chamar erro
        }
//        try {
//            CadastroProdutoDAO cad = new CadastroProdutoDAO();
//            boolean verdade = cad.read(user, password);
//            if (verdade) {
//                response.sendRedirect("html/Home.html");
//            } else {
//                //chamar erro
//            }
//        } catch (Exception error) {
//            System.out.println(error);
//        }

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
