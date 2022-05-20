
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * ${table.comment!} 服务实现类
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> {

    @Autowired
    private ${table.mapperName} mapper;

    /**
    * ${table.comment!} 添加信息
    */
    public int add(${entity} entity) {
        return mapper.insert(entity);
    }

    /**
    * ${table.comment!} 根据id删除信息
    */
    public int delete(<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id){
        return mapper.deleteById(id);
    }

    /**
    * ${table.comment!} 编辑信息
    */
    public int update(${entity} entity) {
        return mapper.updateById(entity);
    }

    /**
    * ${table.comment!} 分页获取列表信息
    */
    public PageResult<${entity}> selectPage(Integer pageNo, Integer pageSize) {
        Page<${entity}> page = new Page<>(pageNo,pageSize);
        LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper<>();
        this.page(page, queryWrapper);
        return new PageResult<>(Math.toIntExact(page.getTotal()),page.getRecords());
    }

    /**
    * ${table.comment!} 根据id查询详情
    */
    public ${entity} detail(<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id){
        return this.getById(id);
    }

}
</#if>
