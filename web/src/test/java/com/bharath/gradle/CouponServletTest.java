package com.bharath.gradle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;
import java.io.StringWriter;


public class CouponServletTest {
 
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;

 
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doGet() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        new CouponServlet().doGet(request,response);
        Assert.assertEquals("SUPERSALE", stringWriter.toString());
    }

    @Test
    public void doPost() throws Exception {
        Mockito.when(request.getParameter("coupon")).thenReturn("SUPERSALE");
        Mockito.when(request.getRequestDispatcher("response.jsp")).thenReturn(requestDispatcher);
        new CouponServlet().doPost(request, response);
        Mockito.verify(request).setAttribute("discount", "Discount for coupon SUPERSALE is 50%");
        Mockito.verify(requestDispatcher).forward(request,response);
    }
}