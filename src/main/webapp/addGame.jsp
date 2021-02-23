<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="agregarGameModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Game</h5> 
                <button class="close" data-dismiss="modal"> <span>&times;</span> </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/game?action=insert" method="POST" class="was-validated">
                
                <div class="modal-body">
                	<div class="form-group">
                        <label for="name">Nombre del juego</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    <div class="form-group">
                        <label for="description">Descripción del juego</label>
                        <input type="text" class="form-control" name="description" required />
                    </div>
                    <div class="form-group">
                        <label for="cover">Cover</label>
                        <input type="text" class="form-control" name="cover" required />
                    </div>
                   <div class="form-group">
                        <label for="gender">Genero</label>
                        <select id="gender" name="gender" class="form-control">
                            <option selected value="SURVIVAL">SURVIVAL</option>
                            <option value="ADVENTURES">ADVENTURES</option>
                            <option value="TERROR">TERROR</option>
                            <option value="ACTION">ACTION</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required step="any" />
                    </div>
                    <div class="form-group">
                        <label for="pegi">Pegi</label>
                        <input type="number" class="form-control" name="pegi" required step="any" />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    