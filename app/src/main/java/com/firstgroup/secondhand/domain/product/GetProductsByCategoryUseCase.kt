package com.firstgroup.secondhand.domain.product

import androidx.paging.PagingData
import androidx.paging.map
import com.firstgroup.secondhand.core.data.repositories.product.ProductRepository
import com.firstgroup.secondhand.core.model.Category
import com.firstgroup.secondhand.core.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetProductsByCategoryUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {

    operator fun invoke(param: Category): Flow<PagingData<Product>> {
        return productRepository.getProductsByCategory(param.id).map { pagingData ->
            pagingData.map { it.mapToDomainModel() }
        }
    }

}