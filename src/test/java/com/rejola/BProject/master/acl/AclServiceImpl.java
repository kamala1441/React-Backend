package com.rejola.BProject.master.acl;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.shared.ResultBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AclServiceImpl implements AclService {
private final RoleRepo roleRepo;
private final ModelMapper modelMapper;

    public AclServiceImpl(RoleRepo roleRepo, ModelMapper modelMapper) {
        this.roleRepo = roleRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<JsonNode> getRole() {
        return ResponseEntity.ok(ResultBuilder.successJson(roleRepo.findAll().stream().map(modelMapper::map), "roleList"));
    }
}
