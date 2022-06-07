package io.muenchendigital.digiwf.digiwf_task_service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** The view controller. */
@Controller
public class ViewController {

  @GetMapping(path = {"", "taskana/**"})
  public String index() {
    return "forward:/index.html";
  }
}
