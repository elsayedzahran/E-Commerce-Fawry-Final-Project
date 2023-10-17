package com.fawry.store.services.serviceimp;

import com.fawry.store.dtos.InventoryDto;
import com.fawry.store.entites.Inventory;
import com.fawry.store.exceptions.NoSuchEntityException;
import com.fawry.store.repos.InventoryRepo;
import com.fawry.store.services.InventoryService;
import com.fawry.store.services.mapper.InventoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class InventoryServiceImp implements InventoryService {

    final String INVENTORY_NOT_FOUND = "INVENTORY_NOT_FOUND";
    private final InventoryRepo repo;
    private final InventoryMapper mapper;

    @Override
    public List<InventoryDto> getAllInventories() {
        return repo.findAll()
                .stream()
                .map(mapper::toInventoryDto)
                .toList();
    }

    @SneakyThrows
    @Override
    public InventoryDto getInventoryById(long id) {
        return mapper.toInventoryDto(repo.findById(id)
                .orElseThrow(() -> new NoSuchEntityException(INVENTORY_NOT_FOUND)));
    }

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        inventoryDto.setDate(new Date());
        return mapper.toInventoryDto(repo.save(mapper.toInventory(inventoryDto)));
    }

    @Override
    public InventoryDto updateInventory(long id, InventoryDto inventoryDto) {
        Inventory inventory = repo.findById(id).orElseThrow(() -> new NoSuchEntityException(INVENTORY_NOT_FOUND));

        inventory.setProductQuantity(inventoryDto.getProductQuantity());

        return mapper.toInventoryDto(repo.save(inventory));
    }

    @Override
    public void destroyInventory(long id) {
        Inventory inventory = repo.findById(id).orElseThrow(() -> new NoSuchEntityException(INVENTORY_NOT_FOUND));
        repo.delete(inventory);
    }


}
