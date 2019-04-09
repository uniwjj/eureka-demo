package com.beidou.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;

/**
 * Token过滤器
 *
 * @author ginger
 * @create 2019-04-10 00:09
 */
public class TokenFilter extends ZuulFilter {

  /**
   * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行 pre：前置过滤器，routing：路由，post：后置，error：其他阶段发生错误时执行
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * filter执行顺序，通过数字指定，数字越大优先级越低
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 判断该过滤器是否需要被执行，实际运用中我们可以利用该函数来指定过滤器的有效范围
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 过滤器的具体逻辑
   */
  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    String token = request.getParameter("token");
    if (token == null || token.trim().isEmpty()) {
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      ctx.setResponseBody("token is blank");
    }
    return null;
  }
}
