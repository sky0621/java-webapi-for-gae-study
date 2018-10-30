package com.example.sky0621;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import com.google.appengine.api.datastore.*;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Unit tests for {@link HelloAppEngine}.
 */

@RunWith(JUnit4.class)
public class HelloAppEngineTest {
  private static final String FAKE_URL = "fake.fk/hello";
  // Set up a helper so that the ApiProxy returns a valid environment for local testing.
  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

  @Mock private HttpServletRequest mockRequest;
  @Mock private HttpServletResponse mockResponse;
  private StringWriter responseWriter;
  private HelloAppEngine servletUnderTest;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    helper.setUp();

    //  Set up some fake HTTP requests
    when(mockRequest.getRequestURI()).thenReturn(FAKE_URL);

    // Set up a fake HTTP response.
    responseWriter = new StringWriter();
    when(mockResponse.getWriter()).thenReturn(new PrintWriter(responseWriter));

    servletUnderTest = new HelloAppEngine();
  }

  @After public void tearDown() {
    helper.tearDown();
  }

  @Test
  public void doGet_writesResponse() throws Exception {
    servletUnderTest.doGet(mockRequest, mockResponse);

    // We expect our hello world response.
    assertThat(responseWriter.toString())
        .named("HelloAppEngine response")
        .contains("Hello App Engine - Standard ");
  }

  @Test
  public void HelloInfo_test() {
    String result = HelloAppEngine.getInfo();
    assertThat(result)
      .named("HelloAppEngine.getInfo")
      .containsMatch("^Version:\\s+.+OS:\\s+.+User:\\s");
  }

  @Test
  public void 書籍名をPOSTするとDatastoreに登録される() throws EntityNotFoundException, ServletException, IOException {
    /*
     * SetUp
     */
    when(mockRequest.getParameter("id")).thenReturn("5");
    when(mockRequest.getParameter("name")).thenReturn("マイクロサービスアーキテクチャ");

    /*
     * Execute
     */
    servletUnderTest.doPost(mockRequest, mockResponse);

    /*
     * Assert
     */
    DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
    Entity e = ds.get(KeyFactory.createKey("book", 5));
    String microService = (String)e.getProperty("bookName");
    assertThat(microService).isEqualTo("マイクロサービスアーキテクチャ");
  }

}
