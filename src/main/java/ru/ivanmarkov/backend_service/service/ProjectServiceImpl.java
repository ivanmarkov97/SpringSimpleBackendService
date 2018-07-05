package ru.ivanmarkov.backend_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivanmarkov.backend_service.entity.Project;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.repository.ProjectRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int id) {
        try {
            if (projectRepository.findById(id).isPresent()) {
                return projectRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    @Transactional
    public void create(Project project) {
        projectRepository.save(project);
    }

    @Override
    public User getUser(int project_id) {
        if (projectRepository.findById(project_id).isPresent()) {
            return projectRepository.findById(project_id).get().getUser();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Project update(Project project) {
        try{
            if (projectRepository.findById(project.getId()).isPresent()){
                Project old_project = projectRepository.findById(project.getId()).get();
                old_project.setName(project.getName());
                return projectRepository.save(old_project);
            } else {
                return null;
            }
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void delete(int id) {
        try{
            projectRepository.deleteById(id);
        }catch (NoSuchElementException e){
            System.out.println("nothing");
        }
    }
}
