package com.demo.base.controller;

import com.demo.base.pojo.Label;
import com.demo.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"FIND Successfully", labelService.findAll());
    }

    @RequestMapping(value = "/{labelId}" , method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId ){
        return new Result(true, StatusCode.OK,"FIND Successfully", labelService.findById(labelId));
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"Save Successfully");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"Update Successfully");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.POST)
    public Result deleteById(@PathVariable("labelId") String labelId, @RequestBody Label label){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK,"delete Successfully");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label>list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK,"FIND Successfully",list);

    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size){
        Page<Label> pageData = labelService.pageQuery(label,page,size);
        return new Result(true, StatusCode.OK,"FIND Successfully",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));

    }
}
