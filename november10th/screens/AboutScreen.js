import { useEffect, useState } from "react"
import { FlatList, Image, StyleSheet, Text, View } from "react-native"
import { MEALS } from "../data/data"



export default function AboutScreen({navigation, route}){
    const id = route.params.id
    const [Jonathan, setJonathan] = useState(MEALS)
    useEffect(()=>{
        console.log(id)
        setJonathan(prevJonathan => prevJonathan.filter((item)=> item.id==id))
        console.log(Jonathan)
    },[])
    return(
<>
<FlatList data={Jonathan} numColumns={2} contentContainerStyle={styles.container} renderItem={({ item }) => {
                return (
                    <View style={styles.container}>
                    <Text style={styles.test}>{item.title}</Text>
                    <Text style={styles.test}>{item.affordability}</Text>
                    <Text style={styles.test}>{item.complexity}</Text>
                    <Image style={styles.image} source={{uri:item.imageUrl}}/>
                    <Text style={styles.test}>{item.duration} minutes</Text>
                    <Text style={styles.test}>{item.ingredients}</Text>
                    <Text style={styles.test}>{item.steps}</Text>          
                    </View>
                )
            }
            } keyExtractor={item => item.id} />


</>

    )
}

const styles = StyleSheet.create({
    container: {
        alignContent: "center"
    },

    test: {
        justifyContent: "space-between",
        backgroundColor: "gray",
    },
    text: {
        color: "black",
    },
    image: {
        width: "100%",
        height: 300,
    }
})
