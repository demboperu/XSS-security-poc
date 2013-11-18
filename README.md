vz-vec-security
===============
 
Basic framework security for backend 

<dl>
<dt>OWASP AntiSamy [ XSS ]</dt>
<dd>
*UserInputSanitizer*

It's a class that remove XSS from the input provide from the Interceptor
         
method
         
sanitize : it's a method that remove XSS code 
         
String xss = "hi <script src=\"#default\"><script>";
             log.info("before : " + xss);
         
             xss = UserInputSanitizer.sanitize(xss);
             log.info("after : " + xss);
             
         result
         
             before : hi <script src="#default"><script>
             after : hi
</dd>
    <dt>store</dt>
    <dd>Users</dd>
</dl>

**

OWASP Antisamy provide classes that identify XSS


    


UserInputSanitizer




VECInterceptor

It's a class that extend of HandlerInterceptorAdapter and intercepter XSS 

methods

preHandler : run before of listener the controller, it's method contains 





