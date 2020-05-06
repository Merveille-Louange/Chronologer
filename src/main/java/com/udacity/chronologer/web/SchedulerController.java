package com.udacity.chronologer.web;



import com.udacity.chronologer.DTO.ScheduleDTO;

import com.udacity.chronologer.entity.Scheduler;
import com.udacity.chronologer.service.SchedulerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchedulerController {
    @Autowired
    SchedulerService schedulerService;

    @GetMapping("/schedule/{id}")
    public ScheduleDTO getScheduleDTO(@PathVariable("id")Long id){
        Scheduler scheduler = schedulerService.getSchedule(id).get();
        return convertEntityToScheduleDTO(scheduler);
    }
    @GetMapping("/schedule")
    public List<ScheduleDTO> getAllScheduleDTO(){
        List<ScheduleDTO> listDto =  new ArrayList<>();
        List<Scheduler> scheduleList = schedulerService.getAllSchedule();
        for (Scheduler schedule : scheduleList) {
            ScheduleDTO scheduleDTO = convertEntityToScheduleDTO(schedule);

            listDto.add(scheduleDTO);
        }
        return listDto;
    }
    @PostMapping("/schedule")
    public void newSchedule(@RequestBody ScheduleDTO schedule){
        Scheduler newSchedule = convertScheduleDTOToEntity(schedule);
        schedulerService.save(newSchedule);
    }

    @DeleteMapping("/schedule/{id}")
    public void deleteEmployee(@PathVariable("id")Long id) {
        schedulerService.delete(id);
    }

    @PutMapping("/schedule/{id}")
    public ScheduleDTO update(@RequestBody ScheduleDTO scheduleDTO){
         Scheduler schedule=convertScheduleDTOToEntity(scheduleDTO);
       Scheduler  newschedule=schedulerService.getUpdate(schedule);

        return convertEntityToScheduleDTO(newschedule);
    }


    private static ScheduleDTO convertEntityToScheduleDTO(Scheduler schedule){
        ScheduleDTO scheduleDTO= new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        return scheduleDTO;
    }

    private static Scheduler convertScheduleDTOToEntity(ScheduleDTO scheduleDTO){
       Scheduler schedule= new Scheduler();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        return schedule;
    }
}
