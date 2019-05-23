const dat = [
    {
        name: 'Folder 1',
        children: [
            {
                name: 'Folder 5'
            }
        ]
    },
    {
        name: 'Folder 2',
        children: [
            {
                name: 'Folder 3',
                children: [
                    {
                        name: 'Folder 4'
                    }
                ]
            },
            {
                name: 'Folder 6'
            }
        ]
    }
]

class TreeConstructor {
    constructor(node, data) {
        this.data = data
        this.root = node
    }

    render() {
        this.root.appendChild(this.generateStructure(this.data))
    }

    generateStructure(data) {
        const ul = document.createElement('ul')

        data.forEach(item => {
            const li = this.createBaseNode(item.name)

            if(Array.isArray(item.children) && item.children.length) {
                li.appendChild(this.generateStructure(item.children))
            }

            ul.appendChild(li)
        })

        return ul
    }

    createBaseNode(text) {
        const li = document.createElement('li')
        const div = document.createElement('div')
        div.textContent = text
        li.appendChild(div)

        return li
    }
}
function directoriesAndTypesConstruct() {
    new TreeConstructor(document.getElementById('directory_root'), ).render()
	new TreeConstructor(document.getElementById('types_root')).render()
}



function CreateRequest()
{
    var Request = false;

    if (window.XMLHttpRequest)
    {
        //Gecko-совместимые браузеры, Safari, Konqueror
        Request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        //Internet explorer
        try
        {
             Request = new ActiveXObject("Microsoft.XMLHTTP");
        }    
        catch (CatchException)
        {
             Request = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
 
    if (!Request)
    {
        alert("Невозможно создать XMLHttpRequest");
    }
    
    return Request;
} 

$(document).ready(function() {
    // вызов функции после потери полем 'userName' фокуса
        $.ajax({
            url : 'directories',     // URL - сервлет
            data : {                 // передаваемые сервлету данные
                name : 'Петя'
            },
            success : function(response) {
                                     // обработка ответа от сервера
                alert(response);
            }
        });
});