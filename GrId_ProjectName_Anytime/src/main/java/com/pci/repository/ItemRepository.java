package com.pci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pci.entity.MtItem;

public interface ItemRepository extends JpaRepository<MtItem, String> {

}
