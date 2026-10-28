package com.example.Barline.data

data class Categories(
    val list: List<Array<String>> = listOf(
        Brass.items,
        Percussion.items,
        Piano.items,
        Strings.items,
        Woodwind.items
    )
)

object Brass {
    val items = arrayOf(
        "Bugle",
        "Cornet",
        "Euphonium",
        "Flugelhorn",
        "French Horn",
        "Trombone",
        "Trumpet",
        "Tuba"
    )
}

object Percussion {
    val items = arrayOf(
        "Auxiliary Percussion",
        "Drum kit",
        "Glockenspiel",
        "Marimba",
        "Mixed Tuned Percussion",
        "Timpani",
        "Tubular Bells",
        "Vibraphone",
        "Xylophone"
    )
}

object Piano {
    val items = arrayOf(
        "Accordion",
        "Harpsichord",
        "Hurdy-gurdy",
        "Keyboard",
        "Organ",
        "Piano"
    )
}

object Strings {
    val items = arrayOf(
        "Acoustic Guitar",
        "Bass Guitar",
        "Cello",
        "Double bass",
        "Electric Guitar",
        "Harp",
        "Ukulele",
        "Viola",
        "Violin"
    )
}

object Woodwind {
    val items = arrayOf(
        "Alto Sax",
        "Baritone Sax",
        "Bassoon",
        "Clarinet",
        "Flute",
        "Oboe",
        "Piccolo",
        "Soprano Sax",
        "Tenor Sax"
    )
}
