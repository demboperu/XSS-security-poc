vz-vec-security
===============
 
Basic framework security for backend 

*OWASP AntiSamy [ XSS ]*

OWASP Antisamy provide classes that identify XSS

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
    
<dl>
    <dt>model</dt>
    <dd>User without HTML encode (uncomment line 14 in app.js)</dd>
    <dt>store</dt>
    <dd>Users</dd>
    <dt>HTML Encode</dt>
    <dd>A way of encode is applicated through function rendered in the view used (line 61 - 64 app.js)</dd>
</dl>

UserInputSanitizer




VECInterceptor

It's a class that extend of HandlerInterceptorAdapter and intercepter XSS 

methods

preHandler : run before of listener the controller, it's method contains 





