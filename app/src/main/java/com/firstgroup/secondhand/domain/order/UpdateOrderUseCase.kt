package com.firstgroup.secondhand.domain.order

import com.firstgroup.secondhand.core.common.dispatchers.AppDispatcher
import com.firstgroup.secondhand.core.common.dispatchers.SecondhandDispatchers.IO
import com.firstgroup.secondhand.core.data.repositories.order.OrderRepository
import com.firstgroup.secondhand.core.model.CreateOrder
import com.firstgroup.secondhand.core.network.order.model.UpdateOrderRequest
import com.firstgroup.secondhand.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UpdateOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
    @AppDispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
) : UseCase<UpdateOrderRequest, CreateOrder>(ioDispatcher) {

    override suspend fun execute(param: UpdateOrderRequest): CreateOrder {
        return orderRepository.updateOrder(param)
    }

}