
import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#--@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")-->
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceImplName} service;

    /**
    * ${table.comment!} 添加信息
    */
    @PostMapping("/${table.entityPath}/add")
    public JsonResponse add(@RequestBody ${entity} entity){
        int n = service.add(entity);
        if(n>0){
            return JsonResponse.success();
        }else{
            return JsonResponse.fail("添加失败");
        }
    }

    /**
    * ${table.comment!} 根据id删除信息
    */
    @DeleteMapping("/${table.entityPath}/delete")
    public JsonResponse delete(@RequestParam <#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id){
        int n = service.delete(id);
        if(n>0){
            return JsonResponse.success();
        }else{
            return JsonResponse.fail("删除失败");
        }
    }

    /**
    * ${table.comment!} 编辑信息
    */
    @PutMapping("/${table.entityPath}/update")
    public JsonResponse update(@RequestBody ${entity} entity){
        int n = service.update(entity);
        if(n>0){
            return JsonResponse.success();
        }else{
            return JsonResponse.fail("更新失败");
        }
    }

    /**
    * ${table.comment!} 分页列表
    */
    @GetMapping(value = "/${table.entityPath}/page")
    public JsonResponse< PageResult<${entity}>> page(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        PageResult<${entity}> pageInfo = service.selectPage(pageNo,pageSize);
        return new JsonResponse<>(pageInfo);
    }

    /**
    * ${table.comment!} 根据id查询详情
    */
    @GetMapping(value = "/${table.entityPath}/detail")
    public JsonResponse<${entity}> detail(@RequestParam <#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id){
        return new JsonResponse<>(service.detail(id));
    }

}
</#if>
