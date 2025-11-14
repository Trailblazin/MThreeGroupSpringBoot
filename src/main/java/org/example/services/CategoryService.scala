package org.example.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.example.repositories.CategoryRepository
import org.example.entities.Category

@Service
class CategoryService @Autowired()(repo: CategoryRepository) {

  def getAll() = repo.findAll()

  def getById(id: Long) =
    repo.findById(id).orElseThrow(() => new RuntimeException("Category not found"))

  def create(category: Category): Category = {
    repo.save(category)
  }

  def update(id: Long, category: Category): Category = {
    val existing = getById(id)
    existing.setName(category.getName)
    repo.save(existing)
  }

  def delete(id: Long): Unit = {
    repo.deleteById(id)
  }
}
