package com.sprAnnotation.conf;

import com.sprAnnotation.aop.LogAspect;
import com.sprAnnotation.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP 【动态代理】:
 *     实现目标：在程序运行期间动态的将某段代码切入到指定的方法指定位置进行编程的方式
 *  1. 导入AOP 模块：Spring AOP (spring-aspects)
 *  2. 定义业务逻辑类 com.sprAnnotation.aop.MathCalculator
 *      在业务逻辑运行时打印日志, 方法前 中 后 及异常 等位置
 *
 *  3. 定义日志切面类 com.sprAnnotation.aop.LogAspect 切面类中的方法需要动态感知
 *     切面类中的方法 称为通知方法：
 *          前置通知(@Before)： logStart: 在目标方法 div 运行前运行
 *          后置通知(@After):  logEnd:  在目标方法 div 运行后运行
 *          返回通知(@AfterReturning):  logRet进方法运行 (joinPoint.Procced())
 *     urn: 在目标方法 div 正常返回之后运行
 *  *          环绕通知(@Around):  动态代理, 手动推     异常通知(@AfterThrowing):  logException: 在目标方法 div 出现异常以后运行
 *  4. 给切面类的目标方法标注 通知注解
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {


    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
