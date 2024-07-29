package model

import shared.getGithubImagePath
import website.composeapp.generated.resources.*

data class ContactPerson(val name: String = "", val image: ResourceAccessor)

private val useRemote = false

fun woelflingsFuehrung(remote: Boolean = useRemote): MutableList<ContactPerson> =
    mutableListOf(lena(remote), helena(remote), rachel(remote))

fun stammesFuehrung(remote: Boolean = useRemote): MutableList<ContactPerson> =
    mutableListOf(michael(remote), phuket(remote))

fun pfadiFuehrung(remote: Boolean = useRemote): MutableList<ContactPerson> =
    stammesFuehrung().apply {
        this.add(0, tobias(remote))
    }

fun roverFuehrung(remote: Boolean = useRemote): MutableList<ContactPerson> =
    mutableListOf(andi(remote))

private fun andi(remote: Boolean = false) =
    ContactPerson(
        name = "Andi",
        image = if (remote) RemoteImageResource(getGithubImagePath("Andi_Headshot")) else LocalImageResource(
            Res.drawable.image_Andi_Headshot
        )
    )

private fun tobias(remote: Boolean = false) =
    ContactPerson(
        name = "Tobi",
        image = if (remote) RemoteImageResource(getGithubImagePath("Tobias_Headshot")) else LocalImageResource(
            Res.drawable.image_Tobias_Headshot
        )
    )

private fun michael(remote: Boolean = false) =
    ContactPerson(
        name = "Michi",
        image = if (remote) RemoteImageResource(getGithubImagePath("Michael_Headshot")) else LocalImageResource(
            Res.drawable.image_Michael_Headshot
        )
    )

private fun phuket(remote: Boolean = false) =
    ContactPerson(
        name = "Phuket",
        image = if (remote) RemoteImageResource(getGithubImagePath("Phuket_Headshot")) else LocalImageResource(
            Res.drawable.image_Phuket_Headshot
        )
    )

private fun lena(remote: Boolean = false) =
    ContactPerson(
        name = "Lena",
        image = if (remote) RemoteImageResource(getGithubImagePath("Lena_Headshot")) else LocalImageResource(
            Res.drawable.image_Lena_Headshot
        )
    )

private fun helena(remote: Boolean = false) =
    ContactPerson(
        name = "Helena",
        image = if (remote) RemoteImageResource(getGithubImagePath("Helena_Headshot")) else LocalImageResource(
            Res.drawable.image_Helena_Headshot
        )
    )

private fun rachel(remote: Boolean = false) =
    ContactPerson(
        name = "Rachel",
        image = if (remote) RemoteImageResource(getGithubImagePath("Rachel_Headshot")) else LocalImageResource(
            Res.drawable.image_Rachel_Headshot
        )
    )