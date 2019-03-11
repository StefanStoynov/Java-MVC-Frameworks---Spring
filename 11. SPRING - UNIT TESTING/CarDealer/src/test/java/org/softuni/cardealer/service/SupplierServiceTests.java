package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Supplier;
import org.softuni.cardealer.domain.models.service.SupplierServiceModel;
import org.softuni.cardealer.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SupplierServiceTests {

    @Autowired
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void supplierService_saveSupplierWithCorrectValues_returnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        SupplierServiceModel toBeSaved = new SupplierServiceModel();
        toBeSaved.setName("gosho");
        toBeSaved.setImporter(true);

        SupplierServiceModel actual = supplierService.saveSupplier(toBeSaved);
        SupplierServiceModel expected = this.modelMapper
                .map(this.supplierRepository.findAll().get(0), SupplierServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isImporter(), actual.isImporter());
    }

    @Test(expected = Exception.class)
    public void supplierService_saveSupplierWithNullValues_TrowsException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        SupplierServiceModel toBeSaved = new SupplierServiceModel();
        toBeSaved.setName(null);
        toBeSaved.setImporter(true);

        supplierService.saveSupplier(toBeSaved);
    }

    @Test
    public void supplierService_editSupplierwithCorrectValues_returnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Gosho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        SupplierServiceModel toBeEditted = new SupplierServiceModel();
        toBeEditted.setId(supplier.getId());
        toBeEditted.setName("Pesho");
        toBeEditted.setImporter(false);

        SupplierServiceModel actual = supplierService.editSupplier(toBeEditted);
        SupplierServiceModel expected = this.modelMapper.map(this.supplierRepository.findAll().get(0), SupplierServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isImporter(), actual.isImporter());
    }

    @Test(expected = Exception.class)
    public void supplierService_editSupplierServiceWithNullValues_TrowsException(){
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Gosho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        SupplierServiceModel toBeEditted = new SupplierServiceModel();
        toBeEditted.setId(supplier.getId());
        toBeEditted.setName(null);
        toBeEditted.setImporter(false);

        supplierService.editSupplier(toBeEditted);
    }

    @Test
    public void supplierService_deleteSupplierWithCorrectValues_returnCorrect(){
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Gosho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        supplierService.deleteSupplier(supplier.getId());

        long expected = 0;
        long actual = supplierRepository.count();

        Assert.assertEquals(expected,actual);
    }

    @Test(expected = Exception.class)
    public void supplierService_deleteSupplierServiceWithNullValues_TrowsException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Gosho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        supplierService.deleteSupplier("InvalidId");
    }

    @Test
    public void supplierService_findSupplierWithCorrectValues_returnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Gosho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        SupplierServiceModel actual = supplierService.findSupplierById(supplier.getId());
        SupplierServiceModel expected = this.modelMapper.map(supplier, SupplierServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isImporter(), actual.isImporter());
    }

    @Test(expected = Exception.class)
    public void supplierService_findSupplierServiceWithNullValues_TrowsException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Gosho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);
        supplierService.findSupplierById("notValidId");
    }
}

