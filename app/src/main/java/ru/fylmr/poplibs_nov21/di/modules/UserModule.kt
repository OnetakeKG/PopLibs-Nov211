package ru.fylmr.poplibs_nov21.di.modules

import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.db.dao.UserDao
import ru.fylmr.poplibs_nov21.di.scope.UserScope
import ru.fylmr.poplibs_nov21.domain.users.GithubUsersRepository
import ru.fylmr.poplibs_nov21.domain.users.IGithubUsersRepository
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus

@Module
class UserModule {

    @Provides
    @UserScope
    fun provideUserRepository(
        apiService: GithubApiService,
        userDao: UserDao,
        networkStatus: NetworkStatus
    ): IGithubUsersRepository {
        return GithubUsersRepository(apiService, userDao, networkStatus)
    }
}