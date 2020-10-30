package qwerty.tourss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qwerty.tourss.Dao.model.Tour;
import qwerty.tourss.Dao.TourDao;

import java.util.List;

@Controller
public class TourController {

    @Autowired
    TourDao tourDao;

    @RequestMapping("/tourform")
    public String showform(Model m) {
        m.addAttribute("command", new Tour());
        return "tourform";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tour") Tour tour) {
        tourDao.save(tour);
        return "redirect:/viewemp";
    }

    @RequestMapping("/viewtour")
    public String viewemp(Model m){
        List<Tour> list = (List<Tour>) tourDao.getEmployees();
        m.addAttribute("list",list);
        return "viewtour";
    }

    @RequestMapping(value="/edittour/{id}")
    public String edit(@PathVariable int id, Model m){
        Tour tour=tourDao.getEmpById(id);
        m.addAttribute("id",id);
        m.addAttribute("tourName",tour.getTourName());
        m.addAttribute("description",tour.getDescription());
        m.addAttribute("country",tour.getCountry());
        m.addAttribute("price",tour.getPrice());
        return "toureditform";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("tour") Tour tour){
        tourDao.update(tour);
        return "redirect:/viewtour";
    }

    @RequestMapping(value="/deletetour/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        tourDao.delete(id);
        return "redirect:/viewtour";
    }
}
