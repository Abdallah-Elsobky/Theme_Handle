package com.example.theme_handle.dummy_data

import androidx.annotation.DrawableRes
import kotlin.random.Random
import java.util.UUID


import com.example.theme_handle.R


object Generator {

    private val userNames = listOf(
        "Ahmed_M", "Fatma_M", "Mohamed_S", "Nour_H", "Abdallah_E",
        "Salma_R", "Khaled_B", "Sara_C", "Omar_L", "Hoda_G"
    )

    private val postDescriptions = listOf(
        "My diet starts tomorrow. Today, I'm just stress-testing my willpower with chocolate. It's failing magnificently. #DietFail #ChocolateIsLife",
        "Just spent 20 minutes looking for my phone while talking on it. Peak performance unlocked. #BrainFog #WhereIsIt",
        "Tried to adult today. Ended up napping on the couch and eating cereal for dinner. 10/10 would recommend. #AdultingIsHard #CerealForDinner",
        "My plants are thriving, my social life isn't. Pretty sure they're judging me. #PlantParent #IntrovertLife",
        "Found a new level of laziness: watching a 'how-to-tie-your-shoes' video instead of tying my own. #LazyGoals #LifeHacks",
        "I’m not saying I’m Batman, I’m just saying no one has ever seen me and Batman in the same room. #SecretIdentity #JustSaying",
        "My cat just gave me a look that clearly said, 'You're doing it wrong.' I fear for my future. #CatOverlords #JudgmentalPets",
        "If you need me, I'll be in my natural habitat: wrapped in a blanket, questioning all my life choices. #CozyVibes #ExistentialCrisis",
        "Accidentally opened my front camera. Got scared. Quickly closed it. We all have those days. #SelfieScare #NoFilterNeeded",
        "Just realized my entire personality is built around avoiding responsibilities. It's working surprisingly well. #ProcrastinationPro #MasterOfAvoidance"
    )

    @DrawableRes
    private val avatarDrawables = listOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.post0,
        R.drawable.post1,
        R.drawable.post3,
        R.drawable.post4,
        R.drawable.post5,
    )

    @DrawableRes
    private val postImageDrawables = listOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.post0,
        R.drawable.post1,
        R.drawable.post3,
        R.drawable.post4,
        R.drawable.post5,
    )

    private var lastStoryAvatarResId: Int? = null
    private var lastPostImageResId: Int? = null

    fun generateRandomStory(): Story {
        val randomUserName = userNames.random()
        var randomAvatar: Int
        do {
            randomAvatar = avatarDrawables.random()
        } while (avatarDrawables.size > 1 && randomAvatar == lastStoryAvatarResId)
        lastStoryAvatarResId = randomAvatar
        val isViewed = Random.nextBoolean()

        return Story(
            id = UUID.randomUUID().toString(),
            userName = randomUserName,
            avatarResId = randomAvatar,
            isViewed = isViewed
        )
    }

    fun generateRandomPost(): Post {
        val randomUserName = userNames.random()
        val randomUserAvatar = avatarDrawables.random()
        var randomPostImage: Int
        do {
            randomPostImage = postImageDrawables.random()
        } while (postImageDrawables.size > 1 && randomPostImage == lastPostImageResId)
        lastPostImageResId = randomPostImage

        val randomDescription = postDescriptions.random()
        val likeCount = Random.nextInt(50, 1000)
        val commentCount = Random.nextInt(0, 150)
        val isLiked = Random.nextBoolean()
        val postTime = "${Random.nextInt(1, 24)} hours ago"

        return Post(
            id = UUID.randomUUID().toString(),
            userId = UUID.randomUUID().toString(),
            userName = randomUserName,
            userAvatarResId = randomUserAvatar,
            postTime = postTime,
            postImageResId = randomPostImage,
            postDescription = randomDescription,
            likeCount = likeCount,
            commentCount = commentCount,
            isLiked = isLiked
        )
    }


    fun generateStories(count: Int): List<Story> {
        return List(count) { generateRandomStory() }
    }

    fun generatePosts(count: Int): List<Post> {
        return List(count) { generateRandomPost() }
    }
}
