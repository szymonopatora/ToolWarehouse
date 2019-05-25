package pl.spatora.service;

import pl.spatora.dao.ToolDao;
import pl.spatora.dao.ToolDaoImpl;
import pl.spatora.model.Tool;
import pl.spatora.model.User;

import java.util.List;
import java.util.Optional;

public class ToolsService {

    private ToolDao toolDao = new ToolDaoImpl();
    private User user = new User();

    public List<Tool> getTools(){
        return toolDao.getAllTools();
    }

    public Optional<Tool> getTool(Long id){
        return toolDao.getAllTools().stream().filter(tool -> tool.getId().equals(id)).findAny();
    }

    public List<Tool> takeTool(Long id){
        return setAvailability(id, false);
    }

    public List<Tool> returnTool(Long id){
        return setAvailability(id, true);
    }

    private List<Tool> setAvailability(Long id, boolean isAvailable){
        toolDao.setAvailability(id, isAvailable);

        return getTools();
    }
}
