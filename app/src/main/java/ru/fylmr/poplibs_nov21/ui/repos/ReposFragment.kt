package ru.fylmr.poplibs_nov21.ui.repos

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.R
import ru.fylmr.poplibs_nov21.databinding.FragmentReposBinding
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.ui.base.BackButtonListener
import ru.fylmr.poplibs_nov21.ui.base.viewBinding
import ru.fylmr.poplibs_nov21.ui.repos.adapter.ReposAdapter

class ReposFragment : MvpAppCompatFragment(R.layout.fragment_repos), ReposView, BackButtonListener {

    private val userModel by lazy {
        requireArguments().getParcelable<GithubUserModel>(KEY_USER_MODEL)!!
    }

    private val binding: FragmentReposBinding by viewBinding()

    private val presenter by moxyPresenter {
        App.instance.initRepoSubcomponent()
        App.instance.reposSubcomponent?.provideReposPresenterFactory()?.presenter(userModel)!!
    }

    private val adapter by lazy {
        ReposAdapter(presenter::onItemClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reposRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecycler.adapter = adapter
    }

    override fun showRepos(repos: List<GithubRepoModel>?) {
        adapter.submitList(repos)
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    companion object {

        private const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(user: GithubUserModel): ReposFragment {
            return ReposFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to user)
            }
        }
    }
}