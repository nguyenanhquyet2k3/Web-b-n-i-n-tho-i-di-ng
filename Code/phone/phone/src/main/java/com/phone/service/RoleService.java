package com.phone.service;

import com.phone.dto.RoleDTO;
import com.phone.entity.Role;
import com.phone.repository.RoleReponsitory;
import com.phone.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements RoleServiceImp {

    @Autowired
    RoleReponsitory roleReponsitory;

    @Override
    public List<RoleDTO> getAllRole() {
        List<Role> listRole = roleReponsitory.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();

        for (Role role : listRole){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setNameRole(role.getNameRole());

            roleDTOList.add(roleDTO);
        }
        return roleDTOList;
    }
}
