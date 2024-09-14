package com.example.mscreditmanager.mapper;



import com.example.mscreditmanager.dao.entity.CustomerEntity;
import com.example.mscreditmanager.model.request.CreateCustomerRequest;
import com.example.mscreditmanager.model.response.CustomerResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public abstract class CustomerMapper {
    public abstract CustomerEntity map(CreateCustomerRequest request);
    public abstract CustomerResponse map(CustomerEntity entity);
}
